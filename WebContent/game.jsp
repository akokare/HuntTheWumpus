<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hunt The Wumpus</title>
	
	<link rel="stylesheet" href="css/wumpus.css"/>
	<script type="text/javascript" src="js/wumpus.js"></script>
	<script type="text/javascript" src="js/shortcut.js"></script>
	<script type="text/javascript" 
			src="http://gc.kis.v2.scr.kaspersky-labs.com/E840FA2C-0A93-454F-8C10-7E3F8FCC22F5/main.js" 
				charset="UTF-8"></script>
<script type="text/javascript">
	shortcut.add("Ctrl+Up",function() { move("up"); });
	shortcut.add("Ctrl+Right",function() { move("right"); });
	shortcut.add("Ctrl+Down",function() { move("down"); });
	shortcut.add("Ctrl+Left",function() { move("left"); });
	shortcut.add("Alt+Up",function() { shoot("up"); });
	shortcut.add("Alt+Right",function() { shoot("right"); });
	shortcut.add("Alt+Down",function() { shoot("down"); });
	shortcut.add("Alt+Left",function() { shoot("left"); });
</script>
</head>

<body>
	<h1>Hunt the Wumpus</h1>
	<p>Arrows remaining: <span id="arrowsLeft">5</span></p>
	<div id="gameBoard"></div>
	
	<form id="movementControls" onsubmit="return false;">
		<p>Move (ctrl+arrow)</p>
		<table>
			<tr>
				<td rowspan="3"><input type="image" src="images/left.png" width="44" height="44" title="left" value="&lt;-" onclick="move('left')" /></td>
				<td><input type="image" src="images/up.png" width="44" height="44" title="up" value="^"  onclick="move('up')" /></td>
				<td rowspan="3"><input type="image" src="images/right.png" width="44" height="44" value="-&gt;"  onclick="move('right')" /></td>
			</tr>
			<tr>
      			<td></td>
    		</tr>
    		<tr>
      			<td><input type="image" src="images/down.png" width="44" height="44" value="v"  onclick="move('down')" /></td>
    		</tr>
		</table>
	</form>
	
	<form id="arrowControls" onsubmit="return false;">
		<p>Shoot (alt+arrow)</p>
		<table>
			<tr>
				<td rowspan="3"><input type="image" src="images/aleft.png" width="44" height="44" title="left" value="&lt;-" onclick="shoot('left')" /></td>
				<td><input type="image" src="images/aup.png" width="44" height="44" title="up" value="^"  onclick="shoot('up')" /></td>
				<td rowspan="3"><input type="image" src="images/aright.png" width="44" height="44" title="right" value="-&gt;"   onclick="shoot('right')" /></td>
			</tr>
			<tr>
      			<td></td>
    		</tr>
    		<tr>
      			<td><input type="image" src="images/adown.png" width="44" height="44" title="down" value="v"   onclick="shoot('down')" /></td>
    		</tr>
		</table>
	</form>
	<h2>Rules Hunt the Wumpus</h2>
	<h3>Rules (for this version)</h3>
	<ol>
  		<li>There are 3 hazards:
    	<ol>
      		<li>A bottomless pit (you will feel a breeze nearby).</li>
      		<li>A colony of bats that will pick you up and drop you in a random space--including potentially deadly spaces (you will hear flapping nearby).</li>
      		<li>A fearsome, hungry, and unbathed wumpus (you will smell it nearby).</li>
    	</ol>
  		</li>
  			<li>The wumpus is heavy; bats cannot lift him.</li>
  			<li>The wumpus is covered in suckers; he won't fall down the bottomless pit.</li>
  			<li>Firing an arrow that misses the wumpus may cause it to move.</li>
  			<li>You have 5 wumpus-piercing arrows.</li>
  			<li>You may find an arrow dropped by a previous hunter.</li>
	</ol>
</body>
</html>