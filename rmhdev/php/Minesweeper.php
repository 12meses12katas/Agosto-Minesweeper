<?php

/**
 * @author rmhdev
 */
class Minesweeper {

    protected $minesweeperParameters;
    protected $squares;

    public function __construct(MinesweeperParameters $minesweeperParameters){
        $this->minesweeperParameters = $minesweeperParameters;
        $this->initializeSquares();
        $this->setMineSquares();
        $this->calculateDistances();
    }

    protected function initializeSquares(){
        $this->squares = array();
        for ($row = 0; $row < $this->getRows(); $row++){
            for ($col = 0; $col < $this->getCols(); $col++){
                $this->initializeSquare($row, $col);
            }
        }
    }

    protected function initializeSquare($row, $col){
        if (!isset($this->squares[$row])){
            $this->squares[$row] = array();
        }
        $this->squares[$row][$col] = 0;
    }

    protected function setMineSquares(){
        foreach ($this->minesweeperParameters->getMines() as $mine){
            list($row, $col) = $mine;
            $this->squares[$row][$col] = MinesweeperParameters::MINE;
        }
    }

    protected function calculateDistances(){
        foreach ($this->squares as $row=>$valuesInRow){
            foreach ($valuesInRow as $col=>$value){
                if (!$this->isMineSquare($value)){
                    $this->updateDistancesForRowCol($row, $col);
                }
            }
        }
    }

    protected function isMineSquareForRowCol($row, $col){
        if (isset($this->squares[$row][$col])){
            return $this->isMineSquare($this->squares[$row][$col]);
        }
        return false;
    }

    protected function isMineSquare($value){
        return $this->minesweeperParameters->isMineSquare($value);
    }

    protected function updateDistancesForRowCol($row, $col){
        $count = 0;
        $count += $this->isMineSquareForRowCol($row - 1  , $col      ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row - 1  , $col + 1  ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row      , $col + 1  ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row + 1  , $col + 1  ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row + 1  , $col      ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row + 1  , $col - 1  ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row      , $col - 1  ) ? 1 : 0;
        $count += $this->isMineSquareForRowCol($row - 1  , $col - 1  ) ? 1 : 0;
        
        $this->squares[$row][$col] += $count;
    }

    public function getRows(){
        return $this->minesweeperParameters->getRows();
    }

    public function getCols(){
        return $this->minesweeperParameters->getCols();
    }

    public function renderRow($row){
        return implode('', $this->squares[$row]);
    }

    public function renderFieldName(){
        return sprintf("Field #%d:", $this->minesweeperParameters->getFieldId());
    }

    public function render(){
        $value = $this->renderFieldName();
        for ($row = 0; $row < $this->getRows(); $row++){
            $value .= MinesweeperParameters::ROW_SEPARATOR;
            $value .= $this->renderRow($row);
        }

        return $value;
    }
    
}
