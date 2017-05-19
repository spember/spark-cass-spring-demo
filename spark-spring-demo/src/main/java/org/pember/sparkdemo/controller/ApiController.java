package org.pember.sparkdemo.controller;

import org.apache.spark.api.java.JavaSparkContext;
import org.pember.sparkdemo.shared.job.AllStocksOverviewJob;
import org.pember.sparkdemo.shared.job.SingleStockOverviewJob;
import org.pember.sparkdemo.shared.pojo.StockOverview;
import org.pember.sparkdemo.shared.pojo.StockQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApiController {
    private JavaSparkContext javaSparkContext;

    @Autowired public ApiController(JavaSparkContext javaSparkContext) {
        this.javaSparkContext = javaSparkContext;
    }

    @RequestMapping(value="/api/stocks", method= RequestMethod.GET, produces="application/json")
    @ResponseBody
    List<StockOverview> query () {
        List<StockOverview> overviews = (new AllStocksOverviewJob()).execute(javaSparkContext, new StockQuery(LocalDate.now().minusDays(30)));
        return overviews;
    }

    @RequestMapping(value="/api/stocks/{stockId}", method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    StockOverview singleQuery (@PathVariable String stockId) {
        StockQuery query = new StockQuery(stockId, LocalDate.now().minusDays(30));
        StockOverview overview = (new SingleStockOverviewJob()).execute(javaSparkContext, query);
        return overview;
    }


}
