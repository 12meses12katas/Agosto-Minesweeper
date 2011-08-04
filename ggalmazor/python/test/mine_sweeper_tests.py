import unittest

class mine_sweeper_tests(unittest.TestCase):
    def test_sabe_cuando_hay_un_campo_definido(self):
        fields = "1 1\n.\n0 0"
        field_count = 0
        self.assertEquals(1, field_count)

        