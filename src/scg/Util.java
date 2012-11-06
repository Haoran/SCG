package scg;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;

/** Various Common utility functions */
public class Util {

    public static final double DELTA = 1E-10;
    static DecimalFormat form = new DecimalFormat("0.000");

    /** returns true if the first double is less than the second */
    public static boolean lessThan(double dec, double mindec){
        return dec + DELTA < mindec;
    }

    /** Format a double for three decimal places */
    public static String format(double d){
        return form.format(d);
    }

    /** Create a span that is a given color */
    public static String color(String s, String color){
        return tag(s, "span", "style=\"color:" + color + "\"");
    }

    /** Add an HTML tag to some text */
    public static String tag(String s, String with){
        return tag(s, with, "");
    }

    /** Add an HTML tag to some text with extra attributes */
    public static String tag(String s, String with, String attrs){
        return "<" + with + " " + attrs + ">" + s + "</" + with + ">";
    }

    static Random rand = new Random();

    /** Random Double between 0..1 */
    public static double random(){
        return rand.nextDouble();
    }

    /** Random Integer between 0..(bound-1) */
    public static int random(int bound){
        return rand.nextInt(bound);
    }

    /** Random coin flip of the given bias */
    public static boolean coinFlip(double bias){
        return Util.random() < bias;
    }

    /** Random coin flip, bias of 0.5 */
    public static boolean coinFlip(){
        return coinFlip(0.5);
    }

    /** Date Format for parsing Dates */
    public static final DateFormat DATEFMT = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
    /** Set the current Time Zone for Date Parsing */
    static {
        DATEFMT.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
        // DateFmt.setTimeZone(TimeZone.getTimeZone("EST"));
    }

    /** Get the current Date/Time */
    public static Date now(){
        return new Date();
    }

    /** Parse a Date from the given String */
    public static Date parseDate(String date) throws java.text.ParseException{
        return DATEFMT.parse(date);
    }

    /** Print a Date in Shortened Format */
    public static String printDate(Date date){
        return DATEFMT.format(date);
    }

    /** Pad out a positive Integer to two digits */
    public static String twoDigits(long n){
        return zeroPad(n, 2);
    }

    static String zeroPad(long n, int ds){
        return zeroPadder(n, (long) Math.pow(10, ds - 1));
    }

    private static String zeroPadder(long n, long max){
        return max <= n || max <= 1 ? "" + n : "0" + zeroPadder(n, max / 10);
    }

    public static String getFileNameSafeDate(Date date){
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        return "_" + zeroPad(c.get(Calendar.YEAR), 4) + "_" + twoDigits((c.get(Calendar.MONTH) + 1)) + "_"
                + twoDigits(c.get(Calendar.DAY_OF_MONTH)) + "_" + twoDigits(c.get(Calendar.HOUR_OF_DAY)) + "_"
                + twoDigits(c.get(Calendar.MINUTE)) + "_" + twoDigits(c.get(Calendar.SECOND));
    }

    /** Is the first Date after the Second Date? */
    public static boolean after(Date d1, Date d2){
        return d1.compareTo(d2) > 0;
    }

    /** Get a Semi-unique Log file name */
    public static String logFileName(String prefix){
        return prefix + "_" + System.currentTimeMillis() / 1000 + ".log";
    }

    /** Hex digits for output */
    private static final String HEX = "0123456789ABCDEF";
    /** Default Hashed Length */
    private static final int DEFAULT_LEN = 16;
    /** Hash implementation */
    private static MessageDigest hasher;
    static {
        try {
            hasher = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) { /* Serious Problems */
        }
    }

    /** Encrypt a given Password (consistently) */
    public static String encrypt(String s){
        return encrypt(s, DEFAULT_LEN);
    }

    /** Encrypt a given Password (consistently) */
    public static String encrypt(String s, int finalLen){
        synchronized (hasher) {
            hasher.reset();
            hasher.update(s.getBytes());
            byte[] bytes = hasher.digest();
            String ret = "";
            for (int i = 0; i < bytes.length && i < finalLen / 2; i++) {
                ret += "" + HEX.charAt(bytes[i] >> 4 & 0xF) + HEX.charAt(bytes[i] & 0xF);
            }
            return ret;
        }
    }

    /** Decode an encoded URL */
    public static String decodeURL(String url){
        try {
            return java.net.URLDecoder.decode(url, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Decode an encoded URL */
    public static String encodeURL(String url){
        try {
            return java.net.URLEncoder.encode(url, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** How long to wait before re-checking */
    private static final int TIMEOUT = 5;

    /** Wait until the given Date */
    public static void waitUntil(Date when){
        while (when.compareTo(now()) > 0) {
            try {
                Thread.sleep(1000 * TIMEOUT);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static <E> edu.neu.ccs.demeterf.lib.List<E> toDemF(Iterable<E> orig){
        return edu.neu.ccs.demeterf.lib.List.create(orig);
    }

    public static Throwable rootCause(Exception e){
        Throwable thrown = e;
        while (thrown.getCause() != null) {
            thrown = thrown.getCause();
        }
        return thrown;
    }

    public static void main(String[] args){
        System.out.println(zeroPad(0, 2));
        System.out.println(zeroPad(1, 2));
        System.out.println(zeroPad(9, 2));
        System.out.println(zeroPad(10, 2));
        System.out.println(zeroPad(11, 2));
        System.out.println(zeroPad(9, 3));
        System.out.println(zeroPad(10, 3));
        System.out.println(zeroPad(11, 3));
        System.out.println(zeroPad(99, 4));
        System.out.println(zeroPad(100, 4));
        System.out.println(zeroPad(101, 4));
    }
    
    /**
     * To create folder
     * @param parentFolder : can be (null or "") else the parent folder relative to the project folder
     * @param folderName : folderName to be created inside parent folder
     */
    public static void createFolder(String parentFolder, String folderName){
        String fullFileName = "";
        if(parentFolder == null || parentFolder.equals("")){
            fullFileName = folderName;
        }else{
            fullFileName = parentFolder + "/" + folderName;
        }
        File file = new File(fullFileName);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
