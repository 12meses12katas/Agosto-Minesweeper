<?php

require_once dirname(__FILE__) . '/CellField.php';

class Field {

    private $fieldId;
    private $cells;
    private $width;
    private $height;
    private $debug;

    /**
     * Constructor 
     * 
     * @param integer $m  columns
     * @param integer $n  lines
     */
    public function __construct($id, $m, $n) {
        //TODO test 0<m<=100  n>0 $id >0
        $this->fieldId = $id;
        $this->width = $m;
        $this->height = $n;
        $this->cells = array();
    }

    public function fillClean() {
        for ($j = 0; $j < $this->height; $j++) {
            for ($i = 0; $i < $this->width; $i++) {
                $this->addCell($i, $j);
            }
        }
    }

    public function printField() {
        $out = array();
        $out[] = sprintf("Field #%s:", $this->fieldId);
        $line = 1;
        $lineText = '';
        foreach ($this->cells as $idx => $cell) {            
            if ($idx < $line * $this->width) {
                $lineText .= $cell->printCell();
            } else {
                $out[] = $lineText;
                $line++;
                $lineText = $cell->printCell();
            }
        }
        $out[] = $lineText;
        return $out;
    }

    public function setFieldId($value) {
        $this->fieldId = $value;
    }

    public function getFieldId() {
        return $this->fieldId;
    }

    public function setWidth($value) {
        $this->width = $value;
    }

    public function setHeight($value) {
        $this->height = $value;
    }

    public function setDebug($value) {
        $this->debug = $value;
    }

    public function getWidth() {
        return $this->width;
    }

    public function getHeight() {
        return $this->height;
    }

    public function addCell($x, $y) {
        $cell = new CellField($x, $y);
        $cell->setDebug($this->debug);
        $this->cells[] = $cell;
    }

    /**
     * Get the cell at position x y in the field
     *  
     * @param integer $x
     * @param integer $y
     * @return CellField 
     */
    public function getCell($x, $y) {
        $key = $this->locateCell($x, $y);
        if ($key === false) {
            throw new Exception('Cell not exist');
        }
        return $this->cells[$key];
    }

    /**
     * Locate a cell in the field
     * 
     * @param integer $x
     * @param integer $y
     * @return integer / boolean 
     */
    private function locateCell($x, $y) {
        foreach ($this->cells as $key => $cell) {
            if (($cell->getX() == $x) && ($cell->getY() == $y)) {
                return $key;
            }
        }
        return false;  //not found
    }

    /**
     * Mine the x,y cell of the field
     * 
     * @param type $x
     * @param type $y 
     */
    public function mineCell($x, $y) {
        $cellMined = $this->getCell($x, $y);
        $cellMined->mine();
        $neighbourCells = $cellMined->getNeighbor($this->width, $this->height);
        foreach ($neighbourCells as $cellCord) {
            $nbCell = $this->getCell($cellCord[0], $cellCord[1]);
            $nbCell->addDanger();
        }
    }

}