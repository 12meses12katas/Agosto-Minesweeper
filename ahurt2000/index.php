<?php
require_once dirname(__FILE__) . '/Exercise.php';

$inputs = array(
'4 4',
'*...',
'....',
'.*..',
'....',
'3 5',
'**...',
'.....',
'.*...',
'0 0',
 );
// mines (0,0) (1,2)
// mines (0,0) (1,0) (1,2)
$fields = array();


$e = new Exercise();
$e->setDebug(false);

$out = $e->process($inputs);

echo implode("\n",$out);