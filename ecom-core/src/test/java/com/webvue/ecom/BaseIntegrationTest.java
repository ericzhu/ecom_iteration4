package com.webvue.ecom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webvue.ecom.config.ApplicatonContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicatonContextConfig.class })
@Commit
public class BaseIntegrationTest {
   
   @Test
   public void test() {
      System.out.println("------------");
   }
}
