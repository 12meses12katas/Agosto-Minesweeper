<?php

/**
 * @author rmhdev
 */
class MinesweeperParameters {

    const MINE = "*";
    const COORD_SEPARATOR = " ";
    const ROW_SEPARATOR = "\n";

    protected $cols;
    protected $rows;
    protected $mines;
    
    public function __construct($parameters){
        $this->setRowsColsFromParameters($parameters);
        $this->setMinesFromParameters($parameters);
    }

    protected function setRowsColsFromParameters($parameters){
        list($rows, $cols) = $this->getRowsColsFromParameters($parameters);
        $this->rows = (int)$rows;
        $this->cols = (int)$cols;
    }

    protected function getRowsColsFromParameters($parameters){
        $parameters = explode(self::ROW_SEPARATOR, $parameters);
        return explode(self::COORD_SEPARATOR, $parameters[0]);
    }

    protected function getDefaultValuesInRowsFromParameters($parameters){
        $parameters = explode(self::ROW_SEPARATOR, $parameters);
        return array_slice($parameters, 1);
    }

    protected function setMinesFromParameters($parameters){
        $this->mines = new ArrayIterator();
        $valuesInRows = $this->getDefaultValuesInRowsFromParameters($parameters);
        foreach ($valuesInRows as $row=>$valuesInRow){
            for ($col = 0; $col < strlen($valuesInRow); $col++){
                if ($valuesInRow[$col] == self::MINE){
                    $this->mines->append(array($row, $col));
                }
            }
        }
    }


    public function getRows(){
        return $this->rows;
    }

    public function getCols(){
        return $this->cols;
    }

    /**
     * @return ArrayIterator
     */
    public function getMines(){
        return $this->mines;
    }

}
