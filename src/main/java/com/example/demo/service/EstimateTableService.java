package com.example.demo.service;

import com.example.demo.model.TableModel;
import com.example.demo.model.TimeModel;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class EstimateTableService {

    private List<TableModel> tableModels = new LinkedList<>();

    private List<TimeModel> sortData(List<TimeModel> inputList) {
        return inputList
                .stream()
                .sorted(Comparator.comparing((TimeModel timeModel) -> timeModel.getCheckIn())
                        .thenComparing(TimeModel::getCheckIn))
                .collect(Collectors.toList());
    }

    private void initialFirstTable(TimeModel timeModel) {
        tableModels.add(new TableModel(0L, timeModel));
    }

    private Boolean isOverlap(TimeModel timeModelFirst, TimeModel timeModelSecond) {
        Date firstCheckIn = timeModelFirst.getDate(timeModelFirst.getCheckIn());
        Date firstCheckOut = timeModelFirst.getDate(timeModelFirst.getCheckOut());
        Date secondCheckIn = timeModelFirst.getDate(timeModelSecond.getCheckIn());
        Date secondCheckOut = timeModelFirst.getDate(timeModelSecond.getCheckOut());
        if ((secondCheckIn.before(firstCheckOut) && firstCheckIn.before(secondCheckIn)) ||
                (firstCheckIn.before(secondCheckOut) && secondCheckIn.before(firstCheckIn)) ||
                (!firstCheckIn.before(secondCheckIn) && !secondCheckIn.before(firstCheckIn))) {
            return true;
        }
        return false;
    }

    private void checkAvailableTable(TimeModel timeModel) {
        for (int i = 0; i < tableModels.size(); i++) {
            if (isOverlap(timeModel, tableModels.get(i).getTimeModel()) && i == tableModels.size() - 1) {
                tableModels.add(new TableModel(Long.valueOf(tableModels.size() - 1), timeModel));
                break;
            }
            if (!isOverlap(timeModel, tableModels.get(i).getTimeModel())) {
                tableModels.get(i).setTimeModel(timeModel);
                break;
            }
        }
    }

    public Integer estimate(List<TimeModel> inputList) {
        List<TimeModel> customers = sortData(inputList);

        if (!customers.isEmpty()) {
            initialFirstTable(customers.get(0));
        }

        for (int i = 1; i < customers.size(); i++) {
            checkAvailableTable(customers.get(i));
        }

        return tableModels.size();
    }

}
