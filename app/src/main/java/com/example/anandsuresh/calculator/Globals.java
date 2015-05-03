package com.example.anandsuresh.calculator;

import android.app.Application;

/**
 * Created by anandsuresh on 4/29/15.
 */
    public class Globals extends Application {
        private double gNumber;

        public double getGnumber() {
            return gNumber;
        }

        public void setGnumber(double gNumber) {
            this.gNumber = gNumber;
        }
    }

