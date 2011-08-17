<?php

/**
 * CellField class 
 *
 * @author ahurt2000
 */
class CellField {

    private $x;
    private $y;
    private $mined;
    private $danger;
    private $debug;
    
    public function __construct($x, $y) {
        $this->setPosition($x, $y);
        $this->setDanger(0);
    }

    public function setPosition($x, $y) {
        $this->setX($x);
        $this->setY($y);
    }

    public function setX($value) {
        $this->x = $value;
    }

    public function setY($value) {
        $this->y = $value;
    }
    
    public function setDebug($value)
    {
        $this->debug = $value;
    }
    
    public function getX() {
        return $this->x;
    }

    public function getY() {
        return $this->y;
    }

    public function getDanger() {
        return $this->danger;
    }    

    private function setDanger($value) {
        $this->danger = $value;
    }

    public function addDanger() {
        $this->danger++;
    }

    public function printCell()
    {
        if($this->debug)
        {
            return $this->getX()."-".$this->getY()." ";
        }
        if($this->isMined()){
            return "*";
        }else{
            return $this->danger;
        }
    }

    /**
     * returns to neighboring cells.
     * 
     * @param integer $m   x boundary 
     * @param integer $n   y boundary
     * @return array() 
     */
    public function getNeighbor($m, $n) {
        $ret = array();
        for ($j = -1; $j <= 1; $j++) {
            for ($i = -1; $i <= 1; $i++) {
                $x = $this->x + $i;
                $y = $this->y + $j;
                if ( !($x == $this->x && $y == $this->y)  
                    &&  ( $x >= 0 ) && ( $y >= 0 ) 
                    && ( $x < $m )  && ( $y < $n )   
                 ) {
                        $ret[] = array($x, $y);
                }
            }
        }
        return $ret;
    }

    public function mine() {
        $this->mined = true;
    }

    public function isMined() {
        return $this->mined;
    }

}

?>
