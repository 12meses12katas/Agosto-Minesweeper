<?php

require_once dirname(__FILE__) . '/../../src/SourceFile.php';

/**
 * Test class for SourceFile.
 */
class SourceFileTest extends PHPUnit_Framework_TestCase
{

    /**
     * @var SourceFile
     */
    protected $object;

    /**
     * Sets up the fixture, for example, opens a network connection.
     * This method is called before a test is executed.
     */
    protected function setUp()
    {
        $this->object = new SourceFile;
    }

    /**
     * Test the method setSource().
     */
    public function testSetSource()
    {
        $source = 'MY_SOURCE';
        $this->object->setSource( $source );
        
        $this->assertAttributeEquals( $source, 'source', $this->object );
    }

    /**
     * Test the method getData().
     */
    public function testGetData()
    {
        $source     = dirname( __FILE__ ) . '/SourceFileTestInput.dat';
        $this->object->setSource( $source );
        $result     = $this->object->getData();
        $expected   = 10;
        
        $this->assertEquals( $expected, count( $result ) );

        $expected   = '0 0';
        $this->assertContains( $expected, $result[9] );
    }

}

?>
