package com.example.demo.service;

import com.example.demo.model.TimeModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EstimateTableServiceTest {

    @InjectMocks
    private EstimateTableService estimateTableService;

    private List<TimeModel> inputList;

    @Before
    public void setup() {
        inputList = new LinkedList<>();
    }

    private void setCustomersCaseSuccess2() {
        inputList.add(new TimeModel("10:00", "12:00"));
        inputList.add(new TimeModel("09:00", "11:00"));
        inputList.add(new TimeModel("08:00", "10:00"));
    }

    private void setCustomersCaseSuccess5() {
        inputList.add(new TimeModel("08:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("10:00", "11:00"));
        inputList.add(new TimeModel("10:00", "12:00"));
        inputList.add(new TimeModel("16:00", "17:00"));
        inputList.add(new TimeModel("15:00", "16:00"));
        inputList.add(new TimeModel("11:00", "14:00"));
        inputList.add(new TimeModel("14:00", "15:00"));
        inputList.add(new TimeModel("09:00", "12:00"));
        inputList.add(new TimeModel("08:00", "17:00"));
        inputList.add(new TimeModel("09:00", "11:00"));
    }

    private void setCustomersCaseSuccess10() {
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
    }

    @Test
    public void should_Return0_when_EstimateSuccess() throws Exception {
        Integer expected = 0;

        Integer totalTable = estimateTableService.estimate(inputList);

        Assert.assertEquals(expected, totalTable);
    }

    @Test
    public void should_Return2_when_EstimateSuccess() throws Exception {
        Integer expected = 2;

        setCustomersCaseSuccess2();

        Integer totalTable = estimateTableService.estimate(inputList);

        Assert.assertEquals(expected, totalTable);
    }

    @Test
    public void should_Return5_when_EstimateSuccess() throws Exception {
        Integer expected = 5;

        setCustomersCaseSuccess5();

        Integer totalTable = estimateTableService.estimate(inputList);

        Assert.assertEquals(expected, totalTable);
    }

    @Test
    public void should_Return10_when_EstimateSuccess() throws Exception {
        Integer expected = 10;

        setCustomersCaseSuccess10();

        Integer totalTable = estimateTableService.estimate(inputList);

        Assert.assertEquals(expected, totalTable);
    }

}