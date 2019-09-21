class Test1{
    
    /**
     * 简单测试：对固定字符串 求 hashCode
     */
    @Test
    public void test(){
        String string="aa";
        System.out.println("aa : "+string.hashCode());
        System.out.println("aa : "+hash(string.toCharArray()));
        String string1="String";
        char[] charString=string1.toCharArray();
        System.out.println("String : "+string1.hashCode());
        System.out.println("String : "+hash(string1.toCharArray()));
    }

    /**
     * 测试：对UUID生成的字符串求其对应的hashCode，并与String.hashCode() 对比
     */
    @Test
    public void test2(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid.hashCode());
        System.out.println(hash(uuid.toCharArray()));
    }

    /**
     *  字符串的 hashCode的生成规则： s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * @param array 字符串所对应的字符数组
     * @return 返回值为hashCode
     */
    public static int hash(char[] array) {
        int num=0;
        for (int i=0;i<array.length;i++){
            num=array[i]*pow(31,array.length-i-1)+num;
        }
        return num;
    }

    /**
     * 不能使用Math.pow(x,y); 原因： 返回值为double
     * 设 x^y
     * @param dishu  指的是 x ，（音译：底数）
     * @param zhishu 指的是 y ,（音译：指数）
     * @return
     */
    public static int pow(int dishu,int zhishu){
        if (dishu==0||zhishu==0){
            return 1;
        }
        int temp=dishu;
        for (int i=1;i<zhishu;i++){
            temp=temp*dishu;
        }
        return temp;
    }
}
