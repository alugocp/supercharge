
# Spawn enemies
execute at @p run summon zombie ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon zombie ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon zombie ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon zombie ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon zombie ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon skeleton ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon skeleton ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon skeleton ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon creeper ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon creeper ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon creeper ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon enderman ~ ~ ~ {Tags:["teleport"]}
execute at @p run summon enderman ~ ~ ~ {Tags:["teleport"]}

# Scatter them
execute at @p run spreadplayers ~ ~ 2 30 true @e[tag=teleport]
tag @e[tag=teleport] remove teleport
say "Spawn happened"

# Repeat in 10 minutes
schedule function supercharge:spawn 2000
