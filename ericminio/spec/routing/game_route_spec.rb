require 'spec_helper'

describe "routes for game" do

  it "routes to the game from home" do

    get("/").should route_to("welcome#index")

  end

end