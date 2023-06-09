
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RentalManager from "./components/listers/RentalCards"
import RentalDetail from "./components/listers/RentalDetail"

import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import RentalShopManager from "./components/listers/RentalShopCards"
import RentalShopDetail from "./components/listers/RentalShopDetail"

import NotificationManager from "./components/listers/NotificationCards"
import NotificationDetail from "./components/listers/NotificationDetail"

import StockManager from "./components/listers/StockCards"
import StockDetail from "./components/listers/StockDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/rentals',
                name: 'RentalManager',
                component: RentalManager
            },
            {
                path: '/rentals/:id',
                name: 'RentalDetail',
                component: RentalDetail
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/rentalShops',
                name: 'RentalShopManager',
                component: RentalShopManager
            },
            {
                path: '/rentalShops/:id',
                name: 'RentalShopDetail',
                component: RentalShopDetail
            },

            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },
            {
                path: '/notifications/:id',
                name: 'NotificationDetail',
                component: NotificationDetail
            },

            {
                path: '/stocks',
                name: 'StockManager',
                component: StockManager
            },
            {
                path: '/stocks/:id',
                name: 'StockDetail',
                component: StockDetail
            },



    ]
})
