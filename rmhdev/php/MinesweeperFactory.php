<?php

require_once 'Minesweeper.php';
require_once 'MinesweeperParameters.php';

/**
 * @author rmhdev
 */
class MinesweeperFactory {

    public static function generate($parameters){
        $minesweeperParameters = New MinesweeperParameters($parameters);
        return new Minesweeper($minesweeperParameters);
    }
}

