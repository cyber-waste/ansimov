package yermilov.ansimov.eliasomega

import org.apache.commons.io.FileUtils

def fileFrom = "sample.txt.eliasomega"
def fileTo = "sample.txt.eliasomega.txt"

def fileContent = FileUtils.readFileToString(new File(fileFrom))

def eliasOmega = new EliasOmega()
def decoded = eliasOmega.decode fileContent

FileUtils.writeStringToFile(new File(fileTo), decoded)