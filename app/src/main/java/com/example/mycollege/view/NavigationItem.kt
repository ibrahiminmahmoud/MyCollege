package com.example.mycollege.view

import com.example.mycollege.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){

    object MainScreen : NavigationItem("home_page", R.drawable.ic_baseline_home_24, "الرئيسية")
    object LoginPage : NavigationItem("login_page", R.drawable.ic_baseline_home_24, "تسجيل دخول")
    object Register : NavigationItem("register_page", R.drawable.ic_baseline_home_24, "انشاء حساب")
    object Register1 : NavigationItem("register1_page", R.drawable.ic_baseline_home_24, "انشاء حساب")
    object Poster : NavigationItem("post_page", R.drawable.ic_baseline_local_post_office_24, "اعلانات")
    object Post1 : NavigationItem("post1_page", R.drawable.ic_baseline_local_post_office_24, "عام")
    object Post2 : NavigationItem("post2_page", R.drawable.ic_baseline_local_post_office_24, "خاص")
    object Calender : NavigationItem("calender_page", R.drawable.ic_baseline_calendar_month_24, "تقويم")
    object Tables : NavigationItem("Tables_page", R.drawable.ic_baseline_table_view_24, "جداول")
    object Tablesded : NavigationItem("Tablesded_page", R.drawable.ic_baseline_table_view_24, "جداول")
    object Lectures : NavigationItem("lectures_page", R.drawable.ic_baseline_menu_book_24, "محاضرات")
    object Result : NavigationItem("result_page", R.drawable.ic_outline_wysiwyg_24, "النتيجة")
    object AboutApp: NavigationItem("about_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    object Listoflec: NavigationItem("listoflec_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    object ComposePDFViewer: NavigationItem("pdfview_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    object ComposePDFViewerw: NavigationItem("pdfview_page1",R.drawable.ic_baseline_info_24,"محاضرات")

}
