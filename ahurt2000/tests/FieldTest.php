<?php
require_once dirname(__FILE__) . '/../src/Field.php';

class FieldTest extends PHPUnit_Framework_TestCase
{  
    /**
     * @dataProvider outputProvider
     */  
    public function testPrintField($id, $m, $n, $mines, $r, $msg)
    {
        $field = new Field($id,$m,$n);
        $field->fillClean();
        foreach($mines as $mine)
        {
            $x = $mine[0];
            $y = $mine[1];
            $field->mineCell($x,$y);
        }
        $this->assertEquals($r, $field->printField(),$msg);  
    }
 
    public function outputProvider()
    {   
        return array(
            array( 1 , 4, 4, array(
                array(1,1),
                array(2,2),
            ),array(
                'Field #1:',
                '1110',
                '1*21',
                '12*1',
                '0111'
                ), 'test field #1 fail' ),
            array( 2 , 4, 4, array(
                array(0,0),
                array(1,2),
            ),array(
                'Field #2:',
                '*100',
                '2210',
                '1*10',
                '1110'
                ), 'Readme test field #2 fail' ),            
            array( 3 , 5, 3, array(
                array(0,0),
                array(1,0),
                array(1,2),
            ),array(
                'Field #3:',
                '**100',
                '33200',
                '1*100',
                ), 'Readme test field #3 fail' ),            
        );
    }
}
