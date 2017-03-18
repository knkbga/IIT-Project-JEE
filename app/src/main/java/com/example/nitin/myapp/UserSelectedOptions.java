package com.example.nitin.myapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kanak on 31/10/16.
 */

public class UserSelectedOptions implements Serializable
{
    protected int singleCorrect[];
    protected ArrayList<Integer>[] multipleCorrect;
    protected String numericals[];
    protected UserSelectedOptions(int numberOfSingleCorrect, int numberOfMultipleCorrect, int numberOfNumericals)
    {
        this.singleCorrect = new int[numberOfSingleCorrect];
        this.multipleCorrect =(ArrayList<Integer>[]) new ArrayList[numberOfMultipleCorrect];
        this.numericals = new String[numberOfNumericals];
    }
}