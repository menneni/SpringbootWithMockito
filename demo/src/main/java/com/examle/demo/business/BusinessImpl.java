package com.examle.demo.business;

import com.examle.demo.data.SomeDataService;

public class BusinessImpl {

  SomeDataService someDataService;

  public SomeDataService getSomeDataService() {
    return someDataService;
  }

  public void setSomeDataService(SomeDataService someDataService) {
    this.someDataService = someDataService;
  }

  public int calculateSum(int[] data){
    int sum = 0;
    for (int num : data){
      sum += num;
    }
    return sum;
  }

  public int calculateSumUsingDataService(){
    int sum = 0;
    int[] data = someDataService.retriveAllData();
    for (int num : data){
      sum += num;
    }
    return sum;
  }


}
