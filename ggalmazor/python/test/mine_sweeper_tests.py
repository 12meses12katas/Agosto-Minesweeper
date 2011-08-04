import unittest

EOF = "0 0"

class mine_sweeper_tests(unittest.TestCase):
    def isHeader(self, line):
        return line.count(" ") > 0

    def test_sabe_cuando_hay_un_campo_definido(self):
        fields = "1 1\n.\n0 0"

        field_count = 0
        for line in fields.split("\n"):
            if (self.isHeader(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))

        self.assertEquals(1, field_count)

    def test_sabe_el_ancho_y_el_alto_de_un_campo(self):
        fields = "2 3\n...\n...\n0 0"

        field_count = width = height = 0
        for line in fields.split("\n"):
            if (self.isHeader(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))

        self.assertEquals(2, height)
        self.assertEquals(3, width)



        