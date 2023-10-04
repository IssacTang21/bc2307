package com.hkjava.demo.demofinnhub.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import lombok.Getter;

@Getter
public class Line {

  private Interval interval; // MONTH

  private String symbol;

  private Deque<Point> closePoints; // per month

  // public Line(String symbol, Interval interval) { // DAY, WEEK, MONTH
  //   this.interval = interval; // month
  //   this.symbol = symbol;
  //   this.closePoints = new LinkedList<>();
  //   Comparator<SourcePoint> reversed =
  //       (SourcePoint p1, SourcePoint p2) -> p1.getTranDayTime().getDatetime()
  //           .isAfter(p2.getTranDayTime().getDatetime()) ? -1 : 1;
  //   SourcePoint.sourceMap.get(symbol).stream() //
  //       .filter(s -> {
  //         if (interval == Interval.WEEK)
  //           return s.getTranDayTime().isWeeklyClose();
  //         else if (interval == Interval.MONTH)
  //           return s.getTranDayTime().isMonthlyClose();
  //         else // day
  //           return true;
  //       }).sorted(reversed) //
  //       .forEach(s -> {
  //         // filtered source points, add to closePoints
  //         closePoints.add(s.toPoint());
  //       });
  // }

  // instance method -> calculate
  // public List<Point> movingAverage(int noOfInterval) {
  //   int count = 0;
  //   BigDecimal first = BigDecimal.valueOf(closePoints.poll().getClosePrice().getPrice());
  //   BigDecimal sum = first;
  //   while(count < noOfInterval) {
  //     sum = sum.add(BigDecimal.valueOf(closePoints.poll().getClosePrice().getPrice()));
  //     count++;
  //   }
  //   double avg = sum.doubleValue();
  //   avg = avg / noOfInterval;


  // }

  // Override the Getter
  public List<Point> getClosePoints() {
    List<Point> points = new ArrayList<>();
    points.addAll(this.closePoints);
    return points;
  }
}
