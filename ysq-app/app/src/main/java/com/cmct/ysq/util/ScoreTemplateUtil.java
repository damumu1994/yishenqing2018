package com.cmct.ysq.util;


public class ScoreTemplateUtil {
    // TODO 这个方法没有完善
    public static String  evaluation(double score,double fatRate,double protein,double BMI){
        StringBuffer sb=new StringBuffer();
      return  null;
    }
    private  static String scoreMsg(double score){
        if (score<0 || score>100)
            throw  new RuntimeException("参数有误");
        if (score<60 && score>=0)
            return "小于60分";
        if(score<80 && score>=60)
            return "60-80";
            return  "80-100";
    }
    private  static String BMIMsg(double BMI){
        // 0 18.5    24     28   35
        // 瘦 正常  偏胖 肥胖 极胖
       char calculate=calculateBMI(BMI);
       switch (calculate){
           case 'L':
               return "偏瘦";
           case 'M':
               return "正常";
           case 'N':
               return "偏胖";
           case 'O':
               return "肥胖";
               default:
                   return "极胖";
       }
    }
    private static char calculateBMI(double BMI){
        // 0 18.5    24     28   35
        // 瘦 正常  偏胖 肥胖 极胖
         if (BMI<18.5) return 'L';
         if (BMI>=18.5 && BMI<24) return 'M';
         if (BMI>=24 && BMI<28) return 'N';
        if (BMI>=28 && BMI<35) return 'O';
        return 'P';
    }
  private   static String fatRateMsg(double fatRate){
        //5 10 21 26 低 正常   偏胖 肥胖
        if (fatRate>=5 && fatRate<10)//偏低
        {
            return "您的脂肪率偏低";
        }
      if (fatRate>=10 && fatRate<21)//偏低
      {
          return "您的脂肪率正常";
      }
      if (fatRate>=21 && fatRate<26)//偏低
      {
          return "您的脂肪率偏胖";
      }
        return "您的脂肪率偏肥胖";
    }
    private static String  proteinMsg(double  protein){
       if (protein<16)//偏低
       {
           return "您的蛋白质偏低";
       }
       if (protein>=16 && protein<20){//正常
           return "您的蛋白质标准";
           }
         return "您的蛋白质偏高";
    }
}
