<!--Pulling Awesome Font -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="css/example.css" rel="stylesheet" />
<link href="css/prettify.css" rel="stylesheet" />
<link href="css/morris.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/rapheal.min.js"></script>
<script src="js/morris.js"></script>
<script src="js/prettify.js"></script>
<script src="js/example.js"></script>
<div id="graph"></div>
<pre id="code" class="prettyprint linenums" style="display: none;">
//Use Morris.Bar
Morris.Bar({
  element: 'graph',
  data: [
    {x: '2011 Q1', y: 3, z: 2, a: 3},
    {x: '2011 Q2', y: 2, z: null, a: 1},
    {x: '2011 Q3', y: 0, z: 2, a: 4},
    {x: '2011 Q4', y: 2, z: 4, a: 3}
  ],
  xkey: 'x',
  ykeys: ['y', 'z', 'a'],
  labels: ['Y', 'Z', 'A']
}).on('click', function(i, row){
  console.log(i, row);
});
</pre>