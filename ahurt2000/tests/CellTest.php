<?php

require_once dirname(__FILE__) . '/../src/CellField.php';

class CellTest extends PHPUnit_Framework_TestCase {

    /**
     * @dataProvider dataprovider
     */
    public function testGetNeighbor($x, $y, $m, $n, $r, $msg) {
        $cell = new CellField($x, $y);
        $this->assertEquals($r, $cell->getNeighbor($m, $n), $msg);
    }

    public function dataprovider() {
        return array(
            array(0, 0, 2, 1, array(
                   array(1, 0),    
                ), 'a Cell Neighbor calculation Fail for cell for column'),            
            array(1, 1, 3, 3, array(
                    array(0, 0), array(1, 0), array(2, 0),
                    array(0, 1),              array(2, 1),
                    array(0, 2), array(1, 2), array(2, 2),
                ), 'a Cell Neighbor calculation Fail for cell 1,1 for field 3x2'),
            array(0, 0, 3, 3, array(
                    array(1,0), 
                    array(0, 1), array(1, 1), 
                ), 'a Cell Neighbor calculation Fail for cell 0,0 for field 3x3 top-left bound'),
            array(0, 2, 3, 3, array(
                    array(0, 1),array(1, 1),array(1, 2),
                ), 'a Cell Neighbor calculation Fail for cell 0,2 for field 3x3 bottom-left bound'),
            array(2, 2, 3, 3, array(
                    array(1, 1), array(2,1), array(1,2),
                ), 'a Cell Neighbor calculation Fail for cell 2,2 for field 3x3 bottom-right bound'), 
            array(2, 1, 3, 3, array(
                    array(1, 0), array(2, 0), array(1, 1),
                    array(1, 2),  array(2, 2),
                ), 'a Cell Neighbor calculation Fail for cell 2,1 for field 3x2 middle-left bound'), 
            array(1, 1, 4, 4, array(
                    array(0, 0), array(1, 0), array(2, 0),
                    array(0, 1),              array(2, 1),
                    array(0, 2), array(1, 2), array(2, 2),
                ), 'a Cell Neighbor calculation Fail for cell 1,1 for field 4x4'),   
            array(2, 2, 4, 4, array(
                    array(1, 1), array(2, 1), array(3, 1),
                    array(1, 2),              array(3, 2),
                    array(1, 3), array(2, 3), array(3, 3),
                ), 'a Cell Neighbor calculation Fail for cell 2,2 for field 4x4'),              
            array(3, 0, 4, 4, array(
                    array(2, 0), array(2, 1), array(3, 1),
                ), 'a Cell Neighbor calculation Fail for cell 3,0 for field 4x4 top-right bound'),              
        );
    }

}