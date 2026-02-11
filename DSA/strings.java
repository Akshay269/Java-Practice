public class strings {
    public static void main(String[] args) {
        String s="abcdefghijklmnopqrstuvwxyz";
        int n=s.length();
        
        // char[] charr=s.toCharArray();

        // // System.out.println(charr);

        // for(int i=0;i<n/2;i++){
        //     char temp=charr[i];
        //     charr[i]=charr[n-1-i];
        //     charr[n-1-i]=temp;
        // }

        // // System.out.println(charr);

        // String news=new String(charr);

        // System.out.println(news);

        StringBuilder sb=new StringBuilder(s);

        for(int i=0;i<n/2;i++){
            char temp=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(n-1-i));
            sb.setCharAt(n-1-i,temp);
        }

        System.out.println(sb);




    }

}
