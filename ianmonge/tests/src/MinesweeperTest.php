<?php

require_once dirname(__FILE__) . '/../../src/Minesweeper.php';

/**
 * Test class for Minesweeper.
 */
class MinesweeperTest extends PHPUnit_Framework_TestCase
{

    /**
     * @var Minesweeper
     */
    protected $object;

    /**
     * Sets up the fixture, for example, opens a network connection.
     * This method is called before a test is executed.
     */
    protected function setUp()
    {
        $this->object = new Minesweeper;
    }

    public function providerSetData()
    {
        $field1 = new Field( 2, 2 );
        $field1->setSquareBomb( 0, 0 );
        $field1->setSquareBomb( 1, 1 );

        $field2 = new Field( 2, 2 );
        $field2->setSquareBomb( 0, 0 );
        $field2->setSquareBomb( 0, 1 );
        $field2->setSquareBomb( 1, 0 );
        $field2->setSquareBomb( 1, 1 );
        
        $dataProvider = array(
            'Without fields' => array(
                'data' => array(
                    '0 0',
                ),
                'expected' => array(),
            ),
            'Field without bombs' => array(
                'data' => array(
                    '2 2',
                    '..',
                    '..',
                    '0 0',
                ),
                'expected' => array( new Field( 2, 2 ) ),
            ),
            'Field with bombs' => array(
                'data' => array(
                    '2 2',
                    '*.',
                    '.*',
                    '0 0',
                ),
                'expected' => array( $field1 ),
            ),
            'Field filled of bombs' => array(
                'data' => array(
                    '2 2',
                    '**',
                    '**',
                    '0 0',
                ),
                'expected' => array( $field2 ),
            ),
        );
        
        return $dataProvider;
    }

    /**
     * Test the method setData().
     * 
     * @dataProvider providerSetData
     */
    public function testSetData( $data, $expected )
    {
        $this->object->setData( $data );
        
        $this->assertAttributeEquals( $expected, 'fields', $this->object );
    }

    /**
     * Test the method printSolutions().
     */
    public function testPrintSolutions()
    {
        $data = array(
            '2 2',
            '*.',
            '.*',
            '3 5',
            '*....',
            '.**..',
            '.....',
            '0 0',
        );
        $this->object->setData( $data );
        
        $output = $this->object->printSolutions();
        
        $expected = <<<HEREDOC
Field #1:
*2
2*

Field #2:
*3210
2**10
12210

HEREDOC;
        
        $this->assertEquals( $expected, $output );
    }

}

?>
