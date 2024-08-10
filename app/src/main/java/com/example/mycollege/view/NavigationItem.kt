package com.example.mycollege.view

import com.example.mycollege.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){

    data object MainScreen : NavigationItem("home_page", R.drawable.ic_baseline_home_24, "الرئيسية")
    data object LoginPage : NavigationItem("login_page", R.drawable.ic_baseline_home_24, "تسجيل دخول")
    data object Register : NavigationItem("register_page", R.drawable.ic_baseline_home_24, "انشاء حساب")
    data object Register1 : NavigationItem("register1_page", R.drawable.ic_baseline_home_24, "انشاء حساب")
    data object Poster : NavigationItem("post_page", R.drawable.ic_baseline_local_post_office_24, "اعلانات")
    data object Post1 : NavigationItem("post1_page", R.drawable.ic_baseline_local_post_office_24, "عام")
    data object Post2 : NavigationItem("post2_page", R.drawable.ic_baseline_local_post_office_24, "خاص")
    data object Calender : NavigationItem("calender_page", R.drawable.ic_baseline_calendar_month_24, "تقويم")
    data object Tables : NavigationItem("Tables_page", R.drawable.ic_baseline_table_view_24, "جداول")
    data object Tablesded : NavigationItem("Tablesded_page", R.drawable.ic_baseline_table_view_24, "جداول")
    data object Lectures : NavigationItem("lectures_page", R.drawable.ic_baseline_menu_book_24, "محاضرات")
    data object Result : NavigationItem("result_page", R.drawable.ic_outline_wysiwyg_24, "النتيجة")
    data object AboutApp: NavigationItem("about_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object Listoflec: NavigationItem("listoflec_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object ComposePDFViewer: NavigationItem("pdfview_page",R.drawable.ic_baseline_info_24,"حول التطبيق")
    data object ComposePDFViewerw: NavigationItem("pdfview_page1",R.drawable.ic_baseline_info_24,"محاضرات")
    data object Tester: NavigationItem("tester_page",R.drawable.baseline_library_books_24,"اختبارات")


}
