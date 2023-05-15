"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var timers_1 = require("timers");
var money = 10000;
var buyACar = function (car) {
    return new Promise((function (resolve, reject) {
        (0, timers_1.setTimeout)(function () {
            if (money >= 10000) {
                resolve("can buy " + car);
            }
            else {
                reject("Do not enough money");
            }
        }, 100);
    }));
};
money = 1000;
var promise = buyACar("Vinfast").then(function (value) {
    console.log(value);
}, function (error) {
    console.log(error);
});
