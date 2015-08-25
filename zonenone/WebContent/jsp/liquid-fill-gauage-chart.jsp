<script src="http://d3js.org/d3.v3.min.js" language="JavaScript"></script>
<script src="js/liquidFillGauge.js" language="JavaScript"></script>
<style>
.liquidFillGaugeText {
	font-family: Helvetica;
	font-weight: bold;
}
</style>
<svg id="fillgauge1" width="540px" height="342px"
	onclick="gauge1.update(NewValue());"></svg>

<script language="JavaScript">
	var gauge1 = loadLiquidFillGauge("fillgauge1", 55);
	var config1 = liquidFillGaugeDefaultSettings();
	config1.circleColor = "#FF7777";
	config1.textColor = "#FF4444";
	config1.waveTextColor = "#FFAAAA";
	config1.waveColor = "#FFDDDD";
	config1.circleThickness = 0.2;
	config1.textVertPosition = 0.2;
	config1.waveAnimateTime = 1000;
	function NewValue() {
		if (Math.random() > .5) {
			return Math.round(Math.random() * 100);
		} else {
			return (Math.random() * 100).toFixed(1);
		}
	}
</script>