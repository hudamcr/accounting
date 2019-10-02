package com.perdamaianindonesia.accountingpi

import android.os.Bundle
import android.view.View
import android.annotation.SuppressLint
import android.content.Intent
import android.support.design.widget.TabLayout
import android.widget.ImageView
import android.widget.PopupMenu
import android.support.v4.view.ViewPager
import android.graphics.Color
import android.support.v4.app.*
import android.widget.Toast
import com.perdamaianindonesia.accountingpi.penjualan.PenjualanActivity
import kotlinx.android.synthetic.main.content_main.*


class DashboardActivity : FragmentActivity() {
    private var tab: TabLayout? = null
    var viewPager: ViewPager? = null
    var imageMenu:ImageView?=null
    private val tabIcons = intArrayOf(R.mipmap.ic_menu, R.mipmap.ic_menu, R.mipmap.ic_menu,R.mipmap.ic_menu,R.mipmap.ic_menu,R.mipmap.ic_menu)
    private val tabIcons2 = intArrayOf(R.mipmap.ic_notifikasi, R.mipmap.ic_notifikasi, R.mipmap.ic_notifikasi, R.mipmap.ic_notifikasi, R.mipmap.ic_notifikasi, R.mipmap.ic_notifikasi)
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        imageMenu=findViewById(R.id.imageMenu) as ImageView
        imageMenu!!.setOnClickListener(View.OnClickListener {
            showPopup(it!!)
        })
        linear_dashboard_1.setOnClickListener(View.OnClickListener {
            linear_dashboard_1.setClickable(false);
        })
        linear_dashboard_2.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, PenjualanActivity::class.java)
            startActivity(intent)
            finish()
        })
        linear_dashboard_3.setOnClickListener(View.OnClickListener {
            linear_dashboard_3.setClickable(false);
        })
        linear_dashboard_4.setOnClickListener(View.OnClickListener {
            linear_dashboard_4.setClickable(false);
        })
        linear_dashboard_5.setOnClickListener(View.OnClickListener {
            linear_dashboard_5.setClickable(false);
        })
        linear_dashboard_6.setOnClickListener(View.OnClickListener {
            linear_dashboard_6.setClickable(false);
        })


//        val host = findViewById<View>(R.id.tabHost) as TabHost
//        host.setup()

        //Tab 1
//        var spec: TabHost.TabSpec = host.newTabSpec("Tab One")
//        spec.setContent(R.id.tab1)
//        spec.setIndicator("Tab One")
//        host.addTab(spec)
//
//        //Tab 2
//        spec = host.newTabSpec("Tab Two")
//        spec.setContent(R.id.tab2)
//        spec.setIndicator("Tab Two")
//        host.addTab(spec)
//
//        //Tab 3
//        spec = host.newTabSpec("Tab Three")
//        spec.setContent(R.id.tab3)
//        spec.setIndicator("Tab Three")
//        host.addTab(spec)




        viewPager = findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager!!)
        tab = findViewById(R.id.tab) as TabLayout
        tab!!.setTabGravity(TabLayout.GRAVITY_FILL)
        tab!!.setupWithViewPager(viewPager)
        tab!!.setTabTextColors(
                resources.getColor(R.color.drkgray),
                resources.getColor(R.color.white)
        )
//        setupTabIcons()
//        tab_bottom.setTabGravity(TabLayout.GRAVITY_FILL)
//        tab_bottom.setupWithViewPager(viewPager)
//        tab_bottom.setTabTextColors(
//                resources.getColor(android.R.color.black),
//                resources.getColor(R.color.white)
////        )
//        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                for (i in 0 until tab!!.getTabCount()) {
//                    if(position==0){
//                        tab!!.getTabAt(i)?.getCustomView()?.setBackgroundColor(Color.parseColor("#198C19"))
//                    }
//                    else if(position==1){
//                        tab!!.getTabAt(i)?.getCustomView()?.setBackgroundColor(Color.parseColor("#ffffff"))
//                    }
//                    else if(position==2){
//                        tab!!.getTabAt(i)?.getCustomView()?.setBackgroundColor(Color.parseColor("#f4f4f4"))
//                    }
////                    if (i == position) {
////                        tab!!.getTabAt(i).getCustomView().setBackgroundColor(Color.parseColor("#198C19"))
////                    } else {
////                    }
//                }
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {}
//        })

        tab!!.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tabs: TabLayout.Tab) {
                viewPager!!.setCurrentItem(tabs.getPosition());
                if (tabs.position == 0) {
//                    tab!!.getTabAt(0)?.getCustomView()?.setBackgroundColor(Color.parseColor("#000"))
//                    tab!!.setSelectedTabIndicator(android.R.color.black)
//                    tab!!.setSelectedTabIndicatorColor(Color.RED)
                    tab!!.getTabAt(0)?.icon?.alpha = 225
                    tab!!.getTabAt(1)?.icon?.alpha = 100
                    tab!!.getTabAt(2)?.icon?.alpha = 100
                    tab!!.getTabAt(3)?.icon?.alpha = 100
                    //tab.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
                }
                else if (tabs.position == 1) {
                    tab!!.setSelectedTabIndicatorColor(Color.GRAY)
//                    tab.getTabAt(0)!!.setIcon(tabIcons2[0])
//                    tab.getTabAt(1)!!.setIcon(tabIcons[1])
                    tab!!.getTabAt(0)?.icon?.alpha = 100
                    tab!!.getTabAt(1)?.icon?.alpha = 225
                    tab!!.getTabAt(2)?.icon?.alpha = 100
                    tab!!.getTabAt(3)?.icon?.alpha = 100
                    //tab.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
                }
                else if (tabs.position == 2) {
                    tab!!.setSelectedTabIndicatorColor(Color.GREEN)
                    tab!!.getTabAt(0)?.icon?.alpha = 100
                    tab!!.getTabAt(1)?.icon?.alpha = 100
                    tab!!.getTabAt(2)?.icon?.alpha = 225
                    tab!!.getTabAt(3)?.icon?.alpha = 100
                    //tab.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
                }
                else if (tabs.position == 3) {
                    tab!!.setSelectedTabIndicatorColor(Color.YELLOW)
                    tab!!.getTabAt(0)?.icon?.alpha = 100
                    tab!!.getTabAt(1)?.icon?.alpha = 100
                    tab!!.getTabAt(2)?.icon?.alpha = 100
                    tab!!.getTabAt(3)?.icon?.alpha = 225
                    //tab.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
                }


                //tab.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
                /*                    tab.setTabTextColors(getResources().getColor(R.color.white),
                            getResources().getColor(R.color.white));
  */

            }

            override fun onTabUnselected(tabs: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

//        tab_bottom.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            @SuppressLint("ResourceAsColor")
//            override fun onTabSelected(tabs: TabLayout.Tab) {
//                if (tabs.position == 0) {
//                    tab_bottom.getTabAt(0)?.setIcon(tabIcons[0])
//                    tab_bottom.getTabAt(1)?.setIcon(tabIcons2[1])
//                    tab_bottom.getTabAt(2)?.setIcon(tabIcons2[2])
//                    tab_bottom.getTabAt(3)?.setIcon(tabIcons2[3])
//                    tab_bottom.getTabAt(4)?.setIcon(tabIcons2[4])
//                    tab_bottom.getTabAt(5)?.setIcon(tabIcons2[5])
//                    tab_bottom.getTabAt(0)?.icon?.alpha = 225
//                    tab_bottom.getTabAt(1)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(2)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(3)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(4)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(5)?.icon?.alpha = 100
//                    //tab_bottom.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
//
//                }
//                if (tabs.position == 1) {
//                    tab_bottom.getTabAt(0)?.setIcon(tabIcons2[0])
//                    tab_bottom.getTabAt(1)?.setIcon(tabIcons[1])
//                    tab_bottom.getTabAt(2)?.setIcon(tabIcons2[2])
//                    tab_bottom.getTabAt(3)?.setIcon(tabIcons2[3])
//                    tab_bottom.getTabAt(4)?.setIcon(tabIcons2[4])
//                    tab_bottom.getTabAt(5)?.setIcon(tabIcons2[5])
//                    tab_bottom.getTabAt(0)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(1)?.icon?.alpha = 225
//                    tab_bottom.getTabAt(2)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(3)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(4)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(5)?.icon?.alpha = 100
//                    //tab_bottom.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
//                }
//                if (tabs.position == 2) {
//                    tab_bottom.getTabAt(0)?.setIcon(tabIcons2[0])
//                    tab_bottom.getTabAt(1)?.setIcon(tabIcons2[1])
//                    tab_bottom.getTabAt(2)?.setIcon(tabIcons[2])
//                    tab_bottom.getTabAt(3)?.setIcon(tabIcons2[3])
//                    tab_bottom.getTabAt(4)?.setIcon(tabIcons2[4])
//                    tab_bottom.getTabAt(5)?.setIcon(tabIcons2[5])
//                    tab_bottom.getTabAt(0)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(1)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(2)?.icon?.alpha = 225
//                    tab_bottom.getTabAt(3)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(4)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(5)?.icon?.alpha = 100
//
//                    //tab_bottom.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
//                    /*                    tab_bottom.setTabTextColors(getResources().getColor(R.color.white),
//                            getResources().getColor(R.color.white));
//  */
//                }
//                if (tabs.position == 3) {
//                    tab_bottom.getTabAt(0)?.setIcon(tabIcons2[0])
//                    tab_bottom.getTabAt(1)?.setIcon(tabIcons2[1])
//                    tab_bottom.getTabAt(2)?.setIcon(tabIcons2[2])
//                    tab_bottom.getTabAt(3)?.setIcon(tabIcons[3])
//                    tab_bottom.getTabAt(4)?.setIcon(tabIcons2[4])
//                    tab_bottom.getTabAt(5)?.setIcon(tabIcons2[5])
//                    tab_bottom.getTabAt(0)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(1)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(2)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(3)?.icon?.alpha = 225
//                    tab_bottom.getTabAt(4)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(5)?.icon?.alpha = 100
//
//                    //tab_bottom.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
//                    /*                    tab_bottom.setTabTextColors(getResources().getColor(R.color.white),
//                            getResources().getColor(R.color.white));
//  */
//                }
//
//                if (tabs.position == 4) {
//                    tab_bottom.getTabAt(0)?.setIcon(tabIcons2[0])
//                    tab_bottom.getTabAt(1)?.setIcon(tabIcons2[1])
//                    tab_bottom.getTabAt(2)?.setIcon(tabIcons2[2])
//                    tab_bottom.getTabAt(3)?.setIcon(tabIcons2[3])
//                    tab_bottom.getTabAt(4)?.setIcon(tabIcons[4])
//                    tab_bottom.getTabAt(5)?.setIcon(tabIcons2[5])
//                    tab_bottom.getTabAt(0)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(1)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(2)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(3)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(4)?.icon?.alpha = 225
//                    tab_bottom.getTabAt(5)?.icon?.alpha = 100
//
//                    //tab_bottom.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
//                    /*                    tab_bottom.setTabTextColors(getResources().getColor(R.color.white),
//                            getResources().getColor(R.color.white));
//  */
//                }
//                if (tabs.position == 5) {
//                    tab_bottom.getTabAt(0)?.setIcon(tabIcons2[0])
//                    tab_bottom.getTabAt(1)?.setIcon(tabIcons2[1])
//                    tab_bottom.getTabAt(2)?.setIcon(tabIcons2[2])
//                    tab_bottom.getTabAt(3)?.setIcon(tabIcons2[3])
//                    tab_bottom.getTabAt(4)?.setIcon(tabIcons2[4])
//                    tab_bottom.getTabAt(5)?.setIcon(tabIcons[5])
//                    tab_bottom.getTabAt(0)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(1)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(2)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(3)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(4)?.icon?.alpha = 100
//                    tab_bottom.getTabAt(5)?.icon?.alpha = 225
//
//                    //tab_bottom.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#666565")));
//                    /*                    tab_bottom.setTabTextColors(getResources().getColor(R.color.white),
//                            getResources().getColor(R.color.white));
//  */
//                }
//
//            }
//
//            override fun onTabUnselected(tabs: TabLayout.Tab) {}
//
//            override fun onTabReselected(tab_bottom: TabLayout.Tab) {
//
//            }
//        })

    }

//    private fun setupTabIcons() {
//        tab_bottom.getTabAt(0)?.setIcon(tabIcons2[0])
//        tab_bottom.getTabAt(1)?.setIcon(tabIcons[1])
//        tab_bottom.getTabAt(2)?.setIcon(tabIcons2[2])
//        tab_bottom.getTabAt(3)?.setIcon(tabIcons2[3])
//        tab_bottom.getTabAt(4)?.setIcon(tabIcons2[4])
//        tab_bottom.getTabAt(5)?.setIcon(tabIcons2[5])
//    }

    fun showPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater = popup.getMenuInflater()
        inflater.inflate(R.menu.menu_main, popup.getMenu())
        popup.show()
    }
    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SummaryFragment(), "Summary Penjualan")
        adapter.addFragment(AnalisaKeuanganFragment(), "Analisis Keuangan")
        adapter.addFragment(AnalisisPiutangFragment(), "Analisis Piutang")
        adapter.addFragment(SummaryStokFragment(), "Summary Stok")
        viewPager.adapter = adapter
    }


    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }
    override fun onBackPressed() {
            if(getFragmentManager().getBackStackEntryCount() > 0){
                getFragmentManager().popBackStack()
            }
                super.onBackPressed();
    }
}
