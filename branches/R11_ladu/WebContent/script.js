var req;
var my_divid;
var mozillus = 0;
var appserver_url = "http://localhost:9090/R11_ladu/";

function Initialize_dc() {
	try {
		req = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (oc) {
			req = null;
		}
	}

	if (!req && typeof XMLHttpRequest != "undefined") {
		req = new XMLHttpRequest();
		mozillus = 1;
	}
}

function ShowDiv(divid) {
	if (document.layers)
		document.layers[divid].visibility = "show";
	else
		document.getElementById(divid).style.visibility = "visible";
}

function HideDiv(divid) {
	if (document.layers)
		document.layers[divid].visibility = "hide";
	else
		document.getElementById(divid).style.visibility = "hidden";
}

function show_toode_form() {

	ShowDiv("toode_form");
}

function evaluate_toode_form(id, nimetus) {
	document.forms['toode_form'].tootja.value = id;
	document.forms['toode_form'].tootja_kood.value = nimetus;

}

function show_tooted(id, nimetus) {
	show_toode_form();
	evaluate_toode_form(id, nimetus);
}

function hide_toode_form() {

	HideDiv("toode_form");

}

function get_toode(id) {

	Initialize_dc();
	var start = new Date();
	var url = appserver_url + "productservice?id=" + id;
	url = encodeURI(url);
	if (req != null) {
		req.onreadystatechange = Process_toode_request;
		req.open("GET", url, true);
		req.send(null);

	}

}

function Process_toode_request() {
	var x;

	if (req.readyState == 4) {

		if (req.status == 200) {
			if (req.responseText == "") {
				x = 1;
			} else {

				if (mozillus == 1) {
					var toode = JSON.parse(req.responseText);
				} else {

					var toode = JSON.parse(req.responseText);
				}
				var tootja = toode.tootja;
				var tootja_kood = toode.tootja_kood;

				show_tooted(tootja, tootja_kood);
			}
		} else {
			document.getElementById("ajax_response").innerHTML = "Tekkis probleem andmete saamisega!"
					+ req.statusText;
		}
	}

}