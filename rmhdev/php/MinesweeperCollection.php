<?php

class MinesweeperCollection {

    protected $minesweepers;
    protected $count;

    public function __construct($parameters){
        $this->minesweepers = new ArrayIterator();
        $fieldId = 1;
        while (strlen($parameters) > 0){
            $minesweeperParameters = new MinesweeperParameters($parameters);
            if ($minesweeperParameters->getRows() > 0){
                $minesweeperParameters->setFieldId($fieldId);
                $minesweeper = new Minesweeper($minesweeperParameters);
                $this->minesweepers->append($minesweeper);
                $fieldId++;
            }
            $parameters = $minesweeperParameters->getUnusedParameters();
            
        }
    }

    public function count(){
        return $this->minesweepers->count();
    }

    public function render(){
        $values = array();
        foreach ($this->minesweepers as $minesweeper){
            $values[] = $minesweeper->render();
        }
        $separator = MinesweeperParameters::FIELD_SEPARATOR . MinesweeperParameters::FIELD_SEPARATOR;
        
        return implode($separator, $values);
    }
}
