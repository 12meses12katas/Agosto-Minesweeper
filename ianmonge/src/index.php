<?php

/**
 * Includes required files.
 */
require_once 'Bootstrap.php';
require_once PATH_BASE . '/SourceFile.php';
require_once PATH_BASE . '/Minesweeper.php';

$filename = PATH_BASE . '/input.data';

$source = new SourceFile();
$source->setSource( $filename );
$data = $source->getData();

$minesweeper = new Minesweeper();
$minesweeper->setData( $data );
$minesweeper->processData();

exit( 0 );