package com.marsdev.tornadofx.hansolo.sc

import eu.hansolo.fx.smoothcharts.SmoothedChart
import eu.hansolo.fx.smoothcharts.SmoothedChart.TRANSPARENT_BACKGROUND
import javafx.geometry.Insets
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.effect.InnerShadow
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.*
import javafx.scene.shape.StrokeLineCap
import tornadofx.*

class SCEApp : App(SCEView::class)

class SCEView : View("SmoothCharts Example") {
    val tweaked2Series1 = XYChart.Series<String, Number>()
    val tweaked2Series2 = XYChart.Series<String, Number>()
    val tweaked2Chart = SmoothedChart<String, Number>(CategoryAxis(), NumberAxis())

    val tweakedSeries1 = XYChart.Series<String, Number>()
    var tweakedSeries2 = XYChart.Series<String, Number>()
    var tweakedSeries3 = XYChart.Series<String, Number>()
    var tweakedChart = SmoothedChart<String, Number>(CategoryAxis(), NumberAxis())

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
        tweaked2Chart.isInteractive = true



        tweakedSeries1.name = "Product 1"
        tweakedSeries1.data.add(XYChart.Data("MO", 105))
        tweakedSeries1.data.add(XYChart.Data("TU", 95))
        tweakedSeries1.data.add(XYChart.Data("WE", 112))
        tweakedSeries1.data.add(XYChart.Data("TH", 165))
        tweakedSeries1.data.add(XYChart.Data("FR", 132))
        tweakedSeries1.data.add(XYChart.Data("SA", 120))
        tweakedSeries1.data.add(XYChart.Data("SU", 153))

        tweakedSeries2.name = "Product 2"
        tweakedSeries2.data.add(XYChart.Data("MO", 75))
        tweakedSeries2.data.add(XYChart.Data("TU", 98))
        tweakedSeries2.data.add(XYChart.Data("WE", 145))
        tweakedSeries2.data.add(XYChart.Data("TH", 150))
        tweakedSeries2.data.add(XYChart.Data("FR", 125))
        tweakedSeries2.data.add(XYChart.Data("SA", 141))
        tweakedSeries2.data.add(XYChart.Data("SU", 250))

        tweakedSeries3.name = "Product 3"
        tweakedSeries3.data.add(XYChart.Data("MO", 150))
        tweakedSeries3.data.add(XYChart.Data("TU", 140))
        tweakedSeries3.data.add(XYChart.Data("WE", 125))
        tweakedSeries3.data.add(XYChart.Data("TH", 130))
        tweakedSeries3.data.add(XYChart.Data("FR", 127))
        tweakedSeries3.data.add(XYChart.Data("SA", 150))
        tweakedSeries3.data.add(XYChart.Data("SU", 165))

        // Tweaked Chart
        tweakedChart.data.addAll(tweakedSeries1, tweakedSeries2, tweakedSeries3)
        tweakedChart.isInteractive = true

        // Set the chart type (AREA or LINE);
        tweakedChart.chartType = SmoothedChart.ChartType.LINE

        // Tweak the chart background
        val gradient = RadialGradient(0.0, 0.0, 0.5, 0.25, 0.5, true, CycleMethod.NO_CYCLE,
                Stop(0.0, Color.web("#313A48")),
                Stop(1.0, Color.web("#26262D")))
        tweakedChart.background = Background(BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY))

        // Tweak the chart plot background
        tweakedChart.chartPlotBackground.background = TRANSPARENT_BACKGROUND

        // Tweak the legend
        tweakedChart.setLegendBackground(TRANSPARENT_BACKGROUND)
        tweakedChart.setLegendTextFill(Color.WHITE)

        // Tweak the axis
        tweakedChart.setXAxisTickLabelFill(Color.web("#7A808D"))
        tweakedChart.setYAxisTickLabelFill(Color.web("#7A808D"))
        tweakedChart.setAxisTickMarkFill(Color.TRANSPARENT)
        tweakedChart.setXAxisBorderColor(Color.TRANSPARENT)
        tweakedChart.setYAxisBorderColor(Color.TRANSPARENT)

        // Tweak the grid lines
        tweakedChart.horizontalGridLines.stroke = Color.TRANSPARENT
        val verticalGridLineGradient = LinearGradient(0.0, 0.0, 0.0, 1.0, true, CycleMethod.NO_CYCLE,
                Stop(0.0, Color.TRANSPARENT),
                Stop(0.35, Color.TRANSPARENT),
                Stop(1.0, Color.web("#7A808D")))

        tweakedChart.verticalGridLines.stroke = verticalGridLineGradient
        tweakedChart.isHorizontalZeroLineVisible = false
        tweakedChart.symbolsVisible = false

        // Tweak series colors
        tweakedChart.setSeriesColor(tweakedSeries1, LinearGradient(0.0, 0.0, 1.0, 0.0,
                true, CycleMethod.NO_CYCLE,
                Stop(0.0, Color.web("#54D1FF")),
                Stop(1.0, Color.web("#016AED"))),
                Color.TRANSPARENT)
        tweakedChart.setSeriesColor(tweakedSeries2, LinearGradient(0.0, 0.0, 1.0, 0.0,
                true, CycleMethod.NO_CYCLE,
                Stop(0.0, Color.web("#F9348A")),
                Stop(1.0, Color.web("#EB123A"))),
                Color.TRANSPARENT)
        tweakedChart.setSeriesColor(tweakedSeries3, LinearGradient(0.0, 0.0, 1.0, 0.0,
                true, CycleMethod.NO_CYCLE,
                Stop(0.0, Color.web("#7BFB00")),
                Stop(1.0, Color.web("#FCE207"))),
                Color.TRANSPARENT)

        // Tweak series strokes
        val tweakedSeries1Path = tweakedChart.getStrokePath(tweakedSeries1)
        val tweakedSeries2Path = tweakedChart.getStrokePath(tweakedSeries2)
        val tweakedSeries3Path = tweakedChart.getStrokePath(tweakedSeries3)

        tweakedSeries1Path.strokeWidth = 4.0
        tweakedSeries2Path.strokeWidth = 4.0
        tweakedSeries3Path.strokeWidth = 4.0

        tweakedSeries1Path.strokeLineCap = StrokeLineCap.ROUND
        tweakedSeries2Path.strokeLineCap = StrokeLineCap.ROUND
        tweakedSeries3Path.strokeLineCap = StrokeLineCap.ROUND

        val lineLight = InnerShadow(BlurType.GAUSSIAN, Color.rgb(255, 255, 255, 0.65), 3.0, 0.0, 0.0, 2.0)
        val lineShadow = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.45), 10.0, 0.0, 0.0, 15.0)
        lineShadow.input = lineLight
        tweakedSeries1Path.effect = lineShadow
        tweakedSeries2Path.effect = lineShadow
        tweakedSeries3Path.effect = lineShadow
    }

    override val root =
            tabpane {
                tab("Tweaked Chart 1") {
                    isClosable = false
                    borderpane { center = tweakedChart }

                }

                tab("Tweaked Chart 2") {
                    isClosable = false
                    borderpane { center = tweaked2Chart }

                }
            }
}