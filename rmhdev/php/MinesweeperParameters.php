<?php

/**
 * @author rmhdev
 */
class MinesweeperParameters {

    const MINE = "*";
    const COORD_SEPARATOR = " ";
    const ROW_SEPARATOR = "\n";
    const FIELD_SEPARATOR = "\n";

    protected $cols;
    protected $rows;
    protected $mines;
    protected $fieldId;
    protected $unusedParameters;
    
    public function __construct($parameters){
        $this->setRowsColsFromParameters($parameters);
        $this->setMinesFromParameters($parameters);
        $this->calculateUnusedParameters($parameters);
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
        return array_slice($parameters, 1, $this->getRows());
    }

    protected function setMinesFromParameters($parameters){
        $this->mines = new ArrayIterator();
        $valuesInRows = $this->getDefaultValuesInRowsFromParameters($parameters);
        foreach ($valuesInRows as $row=>$valuesInRow){
            for ($col = 0; $col < strlen($valuesInRow); $col++){
                if ($this->isMineSquare($valuesInRow[$col])){
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

    public function isMineSquare($value){
        return ($value === self::MINE);
    }

    public function setFieldId($fieldId){
        $this->fieldId = $fieldId;
    }

    public function getFieldId(){
        return $this->fieldId;
    }

    public function getUnusedParameters(){
        return $this->unusedParameters;
    }

    protected function calculateUnusedParameters($parameters){
        list($rows, $cols) = $this->getRowsColsFromParameters($parameters);
        $sizeActualParameters =
            $rows*$cols +
            strlen(strval($rows)) + strlen(strval($cols)) +
            $rows*strlen(self::ROW_SEPARATOR) + 
            strlen(self::COORD_SEPARATOR) +
            strlen(self::FIELD_SEPARATOR);

        $this->unusedParameters = substr($parameters, $sizeActualParameters);
    }

}
