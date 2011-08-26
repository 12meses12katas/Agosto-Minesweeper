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

    /**
     * Test the method setData().
     */
    public function testSetData()
    {
        $data = array( "0 0\n" );
        $this->object->setData( $data );
        
        $this->assertAttributeEmpty( 'fields', $this->object );

        $input = <<<HEREDOC
2 2
..
..
0 0

HEREDOC;
        $data = preg_split( '/(\n)/', $input, null, PREG_SPLIT_DELIM_CAPTURE );
        $this->object->setData( $data );
        
        $expected = array( new Field( 2, 2 ) );
        
        $this->assertAttributeEquals( $expected, 'fields', $this->object );

        $input = <<<HEREDOC
2 2
*.
.*
0 0

HEREDOC;
        $data = preg_split( '/(\n)/', $input, null, PREG_SPLIT_DELIM_CAPTURE );
        $this->object->setData( $data );
        
        $field = new Field( 2, 2 );
        $field->setSquareBomb( 0, 0 );
        $field->setSquareBomb( 1, 1 );
        $expected[] = $field ;
        
        $this->assertAttributeEquals( $expected, 'fields', $this->object );

        $input = <<<HEREDOC
2 2
**
**
0 0

HEREDOC;
        $data = preg_split( '/(\n)/', $input, null, PREG_SPLIT_DELIM_CAPTURE );
        $this->object->setData( $data );
        
        $field = new Field( 2, 2 );
        $field->setSquareBomb( 0, 0 );
        $field->setSquareBomb( 0, 1 );
        $field->setSquareBomb( 1, 0 );
        $field->setSquareBomb( 1, 1 );
        $expected[] = $field ;
        
        $this->assertAttributeEquals( $expected, 'fields', $this->object );
    }

    /**
     * Test the method printSolutions().
     */
    public function testPrintSolutions()
    {
        $input = <<<HEREDOC
2 2
*.
.*
3 5
*....
.**..
.....
0 0
HEREDOC;
        $data = preg_split( '/(\n)/', $input, null, PREG_SPLIT_DELIM_CAPTURE );
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
