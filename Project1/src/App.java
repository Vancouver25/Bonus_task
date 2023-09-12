import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


 class Dates {

   
    public static void main(String[] args) {
        int start = 2010; 
        int end = 2015; 
        findDates(start, end);
    }

    public static void findDates(int start, int end) {
        for (int year = start; year <= end; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (valid(year, month, day)) {
                        String dateStr = String.format("%04d%02d%02d", year, month, day);
                        String dateStrReversed = new StringBuilder(dateStr).reverse().toString();
                        
                        if (dateStr.equals(dateStrReversed)) {
                            SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd");
                            try {
                                Date date = temp.parse(year + "-" + month + "-" + day);
                                System.out.println(temp.format(date));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean valid(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); 
        calendar.set(Calendar.DAY_OF_MONTH, day);

        try {
            calendar.getTime(); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}