package UT;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import UT.Q001Test;
import UT.Q231Test;

@RunWith(Suite.class)
@SuiteClasses({ Q001Test.class, Q231Test.class })
public class AllTests {

}
