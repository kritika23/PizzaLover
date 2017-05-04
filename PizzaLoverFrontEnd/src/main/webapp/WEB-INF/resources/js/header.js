/*
 * Custom javascript for http://----.ca
 * Initial version on 2016.02.22 intended for the website's temporary page.
 * Modified on 2016.02.27 to share on bootsnipp.com
 *
 * Created by Mathieu Aubin (mathieu@zeroserieux.com)
 *
 * Contribute to have your name here, no matter how small of a change.
 * 
 * Licenced under the WTFPL Version 2 (http://www.wtfpl.net/)
 *
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 * 
 */

/* Change the numbers to adjust your resize ratio */
function reSize() {
    var n = $("body").width() / 15;
	$("h1").css('fontSize', n + "pt");
	$("h3").css('fontSize', (n/20) * 4.2 + "pt");
	}
$(window).on("resize", reSize);
$(document).ready(reSize);

(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o), m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');  ga('create', 'UA-70761127-6', 'auto');  ga('send', 'pageview');