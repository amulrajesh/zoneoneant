var gridData =
[
    {
        "id": 3,
        "voice": 500,
        "text": 375,
        "name": "Elisa Gallagher",
        "data": "100GB",
        "amt": 1000
    }
];

function addGridData(index, id, name, voice, text, data, amt){
	gridData[index] = {"id":id, "name":name, "voice":voice, "text":text, "data":data, "amt":amt};
	//alert(gridData[0]);
}