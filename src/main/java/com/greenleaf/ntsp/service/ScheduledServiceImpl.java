package com.greenleaf.ntsp.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.greenleaf.ntsp.repository.DayWelfareEntity;
import com.greenleaf.ntsp.repository.DayWelfareJpaDao;
import com.greenleaf.ntsp.service.module.CibaBean;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledServiceImpl.class);

    @Autowired
    DayWelfareJpaDao dayWelfareJpaDao;

    /**
     * {
     *     "sid": "3083",
     *     "tts": "http://news.iciba.com/admin/tts/2018-08-04-day.mp3",
     *     "content": "Burdens are for shoulders strong enough to carry them.",
     *     "note": "沉重的担子是由那些有着坚强的肩膀的人来挑的。",
     *     "love": "988",
     *     "translation": "小编的话：这句话出自《飘》。不要让别人告诉你，你不能做什么。只要有梦想，就要去追求。天将降大任于斯人也，必先苦其心志，劳其筋骨，饿其体肤，空乏其身，行拂乱其所为也。",
     *     "picture": "http://cdn.iciba.com/news/word/20180804.jpg",
     *     "picture2": "http://cdn.iciba.com/news/word/big_20180804b.jpg",
     *     "caption": "词霸每日一句",
     *     "dateline": "2018-08-04",
     *     "s_pv": "0",
     *     "sp_pv": "0",
     *     "tags": [
     *         {
     *             "id": null,
     *             "name": null
     *         }
     *     ],
     *     "fenxiang_img": "http://cdn.iciba.com/web/news/longweibo/imag/2018-08-04.jpg"
     * }
     */
    @Override
    public void pushData() {
        try {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CibaApiService  cibaApiService = retrofit.create(CibaApiService.class);
            retrofit2.Call<CibaBean>  cibaApiServiceDayWelfare = cibaApiService.getDayWelfare();
            CibaBean cibaBean = cibaApiServiceDayWelfare.execute().body();
            if (cibaBean != null) {
                logger.info("result: {} ", cibaBean);
                DayWelfareEntity dayWelfareEntity = new DayWelfareEntity();
                dayWelfareEntity.setTitle(cibaBean.getContent());
                dayWelfareEntity.setContent(cibaBean.getNote());
                dayWelfareEntity.setUrl(cibaBean.getPicture());
                dayWelfareEntity.setUrl2(cibaBean.getPicture2());
                dayWelfareJpaDao.saveAndFlush(dayWelfareEntity);
            } else {
                logger.error("no dayWelfare found");
            }
        } catch (IOException e) {
            logger.error("no dayWelfare found ", e);
        }
    }
}
