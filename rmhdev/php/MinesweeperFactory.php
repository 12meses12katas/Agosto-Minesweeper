<?php

require_once 'Minesweeper.php';
require_once 'MinesweeperParameters.php';
require_once 'MinesweeperCollection.php';

/**
 * @author rmhdev
 */
class MinesweeperFactory {

    public static function generateUnique($parameters){
        $minesweeperParameters = New MinesweeperParameters($parameters);
        $minesweeperParameters->setFieldId(1);
        return new Minesweeper($minesweeperParameters);
    }

    public function generateCollection($parameters){
        return new MinesweeperCollection($parameters);
    }
}

