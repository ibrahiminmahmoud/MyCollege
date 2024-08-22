package com.example.mycollege.view

import com.example.mycollege.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
///=========================MainScreen==========================================////
    data object MainScreen : NavigationItem("home_page", R.drawable.ic_baseline_home_24, "الرئيسية")


    ///=========================LoginScreen==========================================////
    data object LoginPage : NavigationItem("login_page", R.drawable.ic_baseline_home_24, "تسجيل دخول")

    ///=========================Create Account Screen==========================================////
    data object Register : NavigationItem("register_page", R.drawable.ic_baseline_home_24, "انشاء حساب")
    data object Register1 : NavigationItem("register1_page", R.drawable.ic_baseline_home_24, "انشاء حساب")

    ///=========================Post Screen==========================================////
    data object Poster : NavigationItem("post_page", R.drawable.ic_baseline_local_post_office_24, "اعلانات")
    data object Post1 : NavigationItem("post1_page", R.drawable.ic_baseline_local_post_office_24, "عام")
    data object PostViewer1 : NavigationItem("PostViewer1", R.drawable.ic_baseline_local_post_office_24, "عام")
    data object Post2 : NavigationItem("post2_page", R.drawable.ic_baseline_local_post_office_24, "خاص")
    data object PostViewer2 : NavigationItem("PostViewer2", R.drawable.ic_baseline_local_post_office_24, "خاص")


    ///=========================Calender Screen==========================================////
    data object Calender : NavigationItem("calender_page", R.drawable.ic_baseline_calendar_month_24, "تقويم")
    data object CalenderViewer: NavigationItem("CalenderViewer",R.drawable.ic_baseline_info_24,"محاضرات")

    ///=========================Tables Screen==========================================////
    data object Tables : NavigationItem("Tables_page", R.drawable.ic_baseline_table_view_24, "جداول")
    data object Tablesded : NavigationItem("Tablesded_page", R.drawable.ic_baseline_table_view_24, "جداول")
    data object Tablesded1 : NavigationItem("Tablesded_page1", R.drawable.ic_baseline_table_view_24, "جداول")
    data object Tablesded2 : NavigationItem("Tablesded_page2", R.drawable.ic_baseline_table_view_24, "جداول")
    data object TablesViewer1 : NavigationItem("TablesViewer1", R.drawable.ic_baseline_table_view_24, "جداول")
    data object TablesViewer2 : NavigationItem("TablesViewer2", R.drawable.ic_baseline_table_view_24, "جداول")
    data object TablesViewer3 : NavigationItem("TablesViewer3", R.drawable.ic_baseline_table_view_24, "جداول")


    ///=========================Lectures Screen==========================================////
    data object Lectures : NavigationItem("lectures_page", R.drawable.ic_baseline_menu_book_24, "محاضرات")
    data object Listoflec: NavigationItem("listoflec_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Listoflec1: NavigationItem("listoflec_page1",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Listoflec2: NavigationItem("listoflec_page2",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Listoflec3: NavigationItem("listoflec_page3",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object ComposePDFViewer: NavigationItem("pdfview_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object LectuersView: NavigationItem("Listoflec",R.drawable.ic_baseline_info_24,"محاضرات")
    data object LectuersView1: NavigationItem("Listoflec1",R.drawable.ic_baseline_info_24,"محاضرات")
    data object LectuersView2: NavigationItem("Listoflec2",R.drawable.ic_baseline_info_24,"محاضرات")
    data object LectuersView3: NavigationItem("Listoflec3",R.drawable.ic_baseline_info_24,"محاضرات")

    ///=========================Result Screen==========================================////
    data object Result : NavigationItem("result_page", R.drawable.ic_outline_wysiwyg_24, "النتيجة")
    data object ResultViewer: NavigationItem("ResultViewer",R.drawable.ic_baseline_info_24,"محاضرات")

    ///=========================AboutApp Screen==========================================////

    data object AboutApp: NavigationItem("about_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Polices: NavigationItem("Polices",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Services: NavigationItem("Services",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Copywirghit: NavigationItem("Copywirghit",R.drawable.ic_baseline_info_24,"حول التطبيق")


    ///=========================Tester Screen==========================================////
    data object Tester: NavigationItem("tester_page",R.drawable.baseline_library_books_24,"اختبارات")


}
