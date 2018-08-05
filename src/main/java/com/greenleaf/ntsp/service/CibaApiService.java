package com.greenleaf.ntsp.service;

import com.greenleaf.ntsp.service.module.CibaBean;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CibaApiService {
  @GET("/dsapi")
  Call<CibaBean> getDayWelfare();
}