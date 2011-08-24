<?php

require_once dirname(__FILE__) . '/../Exercise.php';

class ExerciseTest extends PHPUnit_Framework_TestCase {

    /**
     * @dataProvider outputProvider
     */
    public function testPrintField($inputs, $out, $msg) {
        $test = new Exercise();
        $test->process($inputs);
        $this->assertEquals($out, $test->getOutput(),$msg);  
    }

    public function outputProvider() {
        return array(
            array(
                array(
                    '4 4',
                    '*...',
                    '....',
                    '.*..',
                    '....',
                    '3 5',
                    '**...',
                    '.....',
                    '.*...',
                    '0 0',                   
                ), array(
                    'Field #1:',
                    '*100',
                    '2210',
                    '1*10',
                    '1110',
                    '',
                    'Field #2:',
                    '**100',
                    '33200',
                    '1*100',
                    '',
                ), 'Readme test Fail'),
        );
    }

}