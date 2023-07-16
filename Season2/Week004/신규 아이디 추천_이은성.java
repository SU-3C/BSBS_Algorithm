 public String solution(String new_id) {

        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        String pattern = "[^0-9a-zA-Z_.-]";
        new_id = new_id.replaceAll(pattern, "");


        //3단계
        String pattern_3 =  "[.]{2,}";
        new_id = new_id.replaceAll(pattern_3,".");

        //4단계
        if(new_id.startsWith(".")){
          new_id = new_id.replaceFirst(".","");
        }
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0,new_id.length() - 1);
        } //-1

        //5단계
        if(new_id.isEmpty()){
            new_id += "a";
        }

        //6단계
        if(new_id.length()>15){
           new_id = new_id.substring(0,15);
           if(new_id.endsWith(".")){
               new_id = new_id.substring(0,new_id.length() - 1);
           }
        }
        //7단계
        if(new_id.length()<3){
            int lastIndex = new_id.length() - 1;
            String lastAlpa = String.valueOf(new_id.charAt(lastIndex));
            StringBuilder sb = new StringBuilder(new_id);
            while (sb.length() < 3) {
                sb.append(lastAlpa);
            }
            new_id = sb.toString();
        }



        String answer = "";
        answer = new_id;
        return answer;
    }
