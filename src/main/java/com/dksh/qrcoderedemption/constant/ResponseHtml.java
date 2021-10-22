package com.dksh.qrcoderedemption.constant;

public class ResponseHtml {

    public static String record_not_found = "<img src=\"\\images\\record_not_found.jpg\">\n" +
                                            "<div class=right_button>\n" +
                                            "\t<img src=\"\\images\\return_small.png\" onmousedown=backToHome()>\n" +
                                            "</div>\n";

    public static String invalid_coupon = "<img src=\"\\images\\cp02-invalid_coupon.png\">\n" +
                                            "<div class=right_button>\n" +
                                            "\t<img src=\"\\images\\cp01-quit.png\" onmousedown=backToHome()>\n" +
                                            "</div>";

    public static String connect_server_failed = "<img src=\"\\images\\connect_server_failed.png\">\n" +
                                                "<div class=right_button>\n" +
                                                "\t<img src=\"\\images\\return_small.png\" onmousedown=backToQueryRecord()>\n" +
                                                "</div>";

    public static String operation_failed = "<img src=\"\\images\\cp03-operation_failed.png\">\n" +
                                            "<div class=right_button>\n" +
                                            "\t<img src=\"\\images\\cp01-quit.png\" onmousedown=backToHome()>\n" +
                                            "</div>";

    public static String over_hour_limit = "<img src=\"\\images\\over_hour_limit.png\">\n" +
                                            "<div class=right_button>\n" +
                                            "\t<img src=\"\\images\\return_small.png\" onmousedown=backToQueryRecord()>\n" +
                                            "</div>";
}
