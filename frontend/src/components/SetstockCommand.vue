<template>

    <v-card outlined>
        <v-card-title>
            Setstock
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <Number label="RentalShopId" v-model="value.rentalShopId" :editMode="editMode"/>
            <String label="CarName" v-model="value.carName" :editMode="editMode"/>
            <String label="CarType" v-model="value.carType" :editMode="editMode"/>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="setstock"
            >
                Setstock
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'SetstockCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.rentalShopId = 0;
            this.value.carName = '';
            this.value.carType = '';
            this.value.qty = 0;
        },
        watch: {
        },
        methods: {
            setstock() {
                this.$emit('setstock', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

