package com.marsdev.tornadofx.hansolo.sc

import eu.hansolo.fx.smoothcharts.SmoothedChart
import eu.hansolo.fx.smoothcharts.SmoothedChart.TRANSPARENT_BACKGROUND
import javafx.geometry.Insets
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import tornadofx.*

class SCEApp : App(SCEView::class)

class SCEView : View("SmoothCharts Example") {
    val tweaked2Series1 = XYChart.Series<String, Number>()
    val tweaked2Series2 = XYChart.Series<String, Number>()
    val tweaked2Chart = SmoothedChart<String, Number>(CategoryAxis(), NumberAxis())

    init {
        tweaked2Series1.name = "Products sold last year"
        tweaked2Series1.data.add(XYChart.Data("Jan", 280))
        tweaked2Series1.data.add(XYChart.Data("Feb", 190))
        tweaked2Series1.data.add(XYChart.Data("Mar", 280))
        tweaked2Series1.data.add(XYChart.Data("Apr", 300))
        tweaked2Series1.data.add(XYChart.Data("May", 205))
        tweaked2Series1.data.add(XYChart.Data("Jun", 430))
        tweaked2Series1.data.add(XYChart.Data("Jul", 380))
        tweaked2Series1.data.add(XYChart.Data("Aug", 180))
        tweaked2Series1.data.add(XYChart.Data("Sep", 300))
        tweaked2Series1.data.add(XYChart.Data("Oct", 440))
        tweaked2Series1.data.add(XYChart.Data("Nov", 300))
        tweaked2Series1.data.add(XYChart.Data("Dec", 390))

        tweaked2Series2.name = "Revenue last year"
        tweaked2Series2.data.add(XYChart.Data("Jan", 600))
        tweaked2Series2.data.add(XYChart.Data("Feb", 760))
        tweaked2Series2.data.add(XYChart.Data("Mar", 585))
        tweaked2Series2.data.add(XYChart.Data("Apr", 410))
        tweaked2Series2.data.add(XYChart.Data("May", 605))
        tweaked2Series2.data.add(XYChart.Data("Jun", 825))
        tweaked2Series2.data.add(XYChart.Data("Jul", 595))
        tweaked2Series2.data.add(XYChart.Data("Aug", 300))
        tweaked2Series2.data.add(XYChart.Data("Sep", 515))
        tweaked2Series2.data.add(XYChart.Data("Oct", 780))
        tweaked2Series2.data.add(XYChart.Data("Nov", 570))
        tweaked2Series2.data.add(XYChart.Data("Dec", 620))

        tweaked2Chart.data.addAll(tweaked2Series1, tweaked2Series2)
        tweaked2Chart.chartType = SmoothedChart.ChartType.AREA
        tweaked2Chart.isInteractive = true
        tweaked2Chart.isSnapToTicks = true

        tweaked2Chart.background = Background(BackgroundFill(Color.web("#293C47"), CornerRadii.EMPTY, Insets.EMPTY))
        tweaked2Chart.chartPlotBackground.background = TRANSPARENT_BACKGROUND
        tweaked2Chart.setXAxisTickLabelFill(Color.web("#85949B"))
        tweaked2Chart.setYAxisTickLabelFill(Color.web("#85949B"))
        tweaked2Chart.setAxisTickMarkFill(Color.TRANSPARENT)
        tweaked2Chart.isHorizontalZeroLineVisible = false
        tweaked2Chart.isVerticalZeroLineVisible = false
        tweaked2Chart.setXAxisBorderColor(Color.TRANSPARENT)
        tweaked2Chart.setYAxisBorderColor(Color.TRANSPARENT)
        tweaked2Chart.setLegendBackground(Color.TRANSPARENT)
        tweaked2Chart.setLegendTextFill(Color.web("#85949B"))

        val horizontalGridLines = tweaked2Chart.horizontalGridLines
        val verticalGridLines = tweaked2Chart.verticalGridLines
        horizontalGridLines.stroke = Color.web("#384C57")
        verticalGridLines.stroke = Color.web("#384C57")

        tweaked2Chart.setSeriesColor(tweaked2Series1, Color.web("#4EE29B"), Color.web("#4EE29B20"))
        tweaked2Chart.getStrokePath(tweaked2Series1).strokeWidth = 3.0
        tweaked2Chart.setSymbolFill(tweaked2Series1, Background(BackgroundFill(Color.web("#26262D"), CornerRadii(1024.0), Insets.EMPTY),
                BackgroundFill(Color.web("#4EE29B"), CornerRadii(1024.0), Insets(2.0))))
        tweaked2Chart.setSymbolSize(tweaked2Series1, 10.0)


        tweaked2Chart.setSeriesColor(tweaked2Series2, Color.web("#00AEF5"), Color.web("#00AEF520"))
        tweaked2Chart.getStrokePath(tweaked2Series2).strokeWidth = 3.0
        tweaked2Chart.setSymbolFill(tweaked2Series2, Background(BackgroundFill(Color.web("#26262D"), CornerRadii(1024.0), Insets.EMPTY),
                BackgroundFill(Color.web("#00AEF5"), CornerRadii(1024.0), Insets(2.0))))

        tweaked2Chart.setSymbolSize(tweaked2Series2, 10.0)
    }

    override val root = borderpane {
        center = tweaked2Chart
    }
}